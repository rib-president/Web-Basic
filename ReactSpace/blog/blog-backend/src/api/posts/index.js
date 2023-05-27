import Router from 'koa-router';
import * as postsCtrl from './posts.ctrl';

const posts = new Router();

posts.get('/', postsCtrl.list);
posts.post('/', postsCtrl.write);

const post = new Router(); // /api/posts/:id
post.get('/', postsCtrl.checkObjectId, postsCtrl.read);
post.delete('/', postsCtrl.checkObjectId, postsCtrl.remove);
post.patch('/', postsCtrl.checkObjectId, postsCtrl.update);

posts.use('/:id', postsCtrl.checkObjectId, post.routes());

export default posts;
