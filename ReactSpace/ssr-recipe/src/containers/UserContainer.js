import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import User from "../components/User";
import { usePreloader } from "../lib/PreloadContext";
import { getUser } from "../modules/users";

const UserContainer = ({ id }) => {
  const user = useSelector((state) => state.users.user);
  const dispatch = useDispatch();

  usePreloader(() => dispatch(getUser(id))); // 서버 사이드 렌더링을 할 때 API 호출

  useEffect(() => {
    if (user && user.id == parseInt(id, 10)) return; // 사용자가 존재하고 id가 일치하다면 요청하지 않음

    dispatch(getUser(id));
  }, [dispatch, id, user]); // id가 바뀔 때 새로 요청

  // 컨테이너 유효성 검사 후 return null을 해야하는 경우에 null 대신 Preloader 반환
  if (!user) {
    return null;
  }
  return <User user={user} />;
};

export default UserContainer;
