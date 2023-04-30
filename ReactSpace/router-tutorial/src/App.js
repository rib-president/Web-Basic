import React from "react";
import { Route, Routes, Link, useLocation } from "react-router-dom";
import About from "./About";
import Home from "./Home";
import Profiles from "./Profiles";
import HistorySample from "./HistorySample";

const App = () => {
  // react-router 버전 업되면서 path="/" -> path="" 등 상대경로, component={Home} -> element{<Home />}으로 변경, multi path 안 됨
  // match, location, history, withRouter -> useParams(), useLocation(), useNavigate()로 변경
  // Switch -> Routes로 변경, render() -> 사라짐(element로 사용)
  return (
    <div>
      <ul>
        <li>
          <Link to="">홈</Link>
        </li>
        <li>
          <Link to="about">소개</Link>
        </li>
        <li>
          <Link to="profiles">프로필</Link>
        </li>
        <li>
          <Link to="history">History 예제</Link>
        </li>
      </ul>
      <hr />

      <Routes>
        <Route path="" element={<Home />} />
        <Route path="about" element={<About />} />
        <Route path="info" element={<About />} />
        <Route path="profiles/*" element={<Profiles />} />
        <Route path="history" element={<HistorySample />} />
        <Route
          path="*" // path를 따로 정의하지 않으면 모든 상황에 렌더링됨
          element={
            <div>
              <h2>이 페이지는 존재하지 않습니다:</h2>
              <p>{useLocation().pathname}</p>
            </div>
          }
        />
      </Routes>
    </div>
  );
};

export default App;
