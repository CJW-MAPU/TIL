import styled from 'styled-components';
import { down } from 'styled-breakpoints';

export const Container = styled.div`
  display: flex;
  justify-content: flex-start;
  align-items: center;
  width: 450px;
  height: 85px;
  border-radius: 10px;
  background-color: #1d1d20;
`;

export const IconStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100px;
  height: 100px;

  ${down("md")} {
    margin-left: 15px;
  }
  
  ${down("sm")} {
    margin-left: 15px;
  }
`;

export const TextStyle = styled.div`
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
  align-items: left;
  width: 320px;
  margin-left: 10px;
  margin-right: 30px;

  span:first-child {
    margin-bottom: 15px;
    font-weight: bold;
  };
`;