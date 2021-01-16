import styled, { css } from 'styled-components';
import { down, up } from 'styled-breakpoints';

const lectureMargin = css`
  ${up("md")} {
    & > div:nth-child(even) {
      margin-left: 70px;
    }
    & > div:nth-child(n + 3) {
      margin-top: 40px;
    }
  }

  ${down("md")} {

  }

  ${down("sm")} {

  }
`;

export const Container = styled.div`
  display: flex;
  justify-content: flex-start;
  align-items: left;
  flex-direction: column;
`;

export const TitleStyle = styled.div`
  margin-left: 63px;
`;

export const GroupStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  margin-top: 30px;
  ${lectureMargin};
  margin-bottom: 100px;
`;