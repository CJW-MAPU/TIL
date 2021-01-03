import React from 'react';
import ScrollableContainer from 'react-full-page-scroll';
import styled from 'styled-components';
import TestHead from './components/TestHead';

const PageComponent = styled.div`
  padding-top: 80px;
`;

const App = () => {
  return (
    <>
      <TestHead />
      <ScrollableContainer animationTime={500}>
        <PageComponent>Page One</PageComponent>
        <PageComponent>Page Two</PageComponent>
        <PageComponent>Page Three</PageComponent>
      </ScrollableContainer>
    </>
  );
};

export default App;
