import React, {useCallback, useEffect} from 'react';
import qs from 'qs';
import {useParams, useLocation} from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import PostList from '../../components/posts/PostList';
import {listPosts} from '../../modules/posts';

const PostListContainer = () => {    

    const dispatch = useDispatch();
    const {posts, error, loading, user} = useSelector(
        ({posts, loading, user}) => ({
            posts: posts.posts,
            error: posts.error,
            loading: loading['posts/LIST_POSTS'],
            user: user.user
        }),
    );
    
    const {search} = useLocation();
    const {username} = useParams();

    const Fetchevent = useCallback(() => {
        
        const {tag, page} = qs.parse(search, {
            ignoreQueryPrefix: true,
        });
        dispatch(listPosts({tag, username, page}));
    }, [dispatch, search, username]);


    useEffect(() => {        
        Fetchevent();                
    }, [Fetchevent]);

    return (
        <PostList
            loading={loading}
            error={error}
            posts={posts}
            showWriteButton={user}
        />
    );
};

export default PostListContainer;