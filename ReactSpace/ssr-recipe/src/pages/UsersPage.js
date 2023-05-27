import React from "react";
import UsersContainer from "../containers/UsersContainer";
import UserContainer from "../containers/UserContainer";
import { Route, Routes } from "react-router-dom";

const UsersPage = () => {
  return (
    <>
      <UsersContainer />;
      <Routes>
        <Route
          path="/users/:id"
          element={({ match }) => <UserContainer id={match.params.id} />}
        />
      </Routes>
    </>
  );
};

export default UsersPage;
