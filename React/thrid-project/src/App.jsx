import React from 'react';
import { createGlobalStyle } from 'styled-components';
import { TodoProvider } from './components/TodoContext';
import TodoCreate from './components/TodoCreate';
import TodoHead from './components/TodoHead';
import TodoList from './components/TodoList';
import TodoTemplate from './components/TodoTemplate';
import SecondSection from './components/section2';
import FirstSection from './components/section1';
import ThirdSection from './components/section3';

const GlobalStyle = createGlobalStyle`
  body {
    background: #e9ecef;
  }
`;

const App = () => {
  return (
    // <TodoProvider>
    //   <GlobalStyle/>
    //   <TodoTemplate>
    //     <TodoHead/>
    //     <TodoList/>
    //     <TodoCreate/>
    //   </TodoTemplate>
    // </TodoProvider>
    <>
      <FirstSection />
      <SecondSection />
      <ThirdSection />
    </>
  );
};

export default App;
