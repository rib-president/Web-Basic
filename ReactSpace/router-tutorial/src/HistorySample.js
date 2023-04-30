import React, { useCallback, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const HistorySample = () => {
  const navigate = useNavigate();
  const [message, setMessage] = useState("");

  useEffect(() => {
    setMessage("정말 떠나실 건가요?");
  }, []);

  useEffect(() => {
    return () => {
      if (message !== "") window.confirm(message);
      else {
      }
    };
  }, [message]);

  const handleGoBack = useCallback(() => {
    navigate(-1);
  }, [navigate]);

  const handleGoHome = useCallback(() => {
    navigate("/");
  }, [navigate]);

  return (
    <div>
      <button onClick={handleGoBack}>뒤로</button>
      <button onClick={handleGoHome}>홈으로</button>
    </div>
  );
};

export default HistorySample;
