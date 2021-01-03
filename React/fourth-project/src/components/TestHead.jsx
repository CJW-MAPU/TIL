import React from 'react';
import styled from 'styled-components';

const TestHeadBlock = styled.div`
  position: fixed;
  left: 0px;
  top: 0px;
  height: 80px;
  width: 100%;
  background-color: black;
  color: white;
`;


const TestHead = () => {
  return (
    <TestHeadBlock>
      asd
    </TestHeadBlock>
  );
};

export default TestHead;