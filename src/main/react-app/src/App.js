/**import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
*/


import React from 'react';
import PlayerList from './PlayerList';

const players = [
  { id: 1, name: '선수1' },
  { id: 2, name: '선수2' },
];

function App() {
  return (
    <div className="App">
      <PlayerList players={players} />
    </div>
  );
}

export default App;
