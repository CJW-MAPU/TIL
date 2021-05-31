import styled from "styled-components";

export const testCors = async () => {

  const url = "http://127.0.0.1:8100/user/ping";

  const headers = {
    "Content-Type": "application/json",
  };

  const options = {
    method: "POST",
    headers,
    credential: "include"
  };

  const response = await fetch(url, options);
  const data = await response.json();
};

export const Button = styled.button`
`;