import React from 'react';
import { createGlobalStyle } from 'styled-components';
import { testCors, Button } from './components/testCors';
import { TodoProvider } from './components/TodoContext';
import TodoCreate from './components/TodoCreate';
import TodoHead from './components/TodoHead';
import TodoList from './components/TodoList';
import TodoTemplate from './components/TodoTemplate';

const GlobalStyle = createGlobalStyle`
  body {
    background: #e9ecef;
  }
`;

const App = () => {
  return (
    <TodoProvider>
      <GlobalStyle/>
      <TodoTemplate>
        {/* <TodoHead/>
        <TodoList/>
        <TodoCreate/> */}
        <Button onClick={testCors}>
        </Button>
      </TodoTemplate>
    </TodoProvider>
  );
};

export default App;
