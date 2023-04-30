import React from "react";
import { NavLink, Route, Routes } from "react-router-dom";
import Profile from "./Profile";

const Profiles = () => {
  // v6부터 render() 사라짐

  const activeStyle = {
    background: "black",
    color: "white",
  };

  return (
    <div>
      <h3>사용자 목록:</h3>
      <ul>
        <li>
          {/* v6부터 activeStyle, activeClassName이 사라짐 -> style, className에 isActive 사용하여 설정 */}
          <NavLink
            style={({ isActive }) => (isActive ? activeStyle : undefined)}
            to="velopert"
          >
            velopert
          </NavLink>
        </li>
        <li>
          <NavLink
            style={({ isActive }) => (isActive ? activeStyle : undefined)}
            to="gildong"
          >
            gildong
          </NavLink>
        </li>
      </ul>

      <Routes>
        <Route path="" element={<div>사용자를 선택해 주세요.</div>} />
        <Route path=":username" element={<Profile />} />
      </Routes>
    </div>
  );
};

export default Profiles;
