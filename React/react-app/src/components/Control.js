import React, { Component } from 'react';

class Control extends Component {
  render() { 
    return (
      <ul>
        <li>
          <a 
            href="/create"
            onClick={function(e) {
              e.preventDefault();
              this.props.onChangeMode('create');
              this.props.onChangePage();
            }.bind(this)}
          >
            create
          </a>
        </li>

        <li>
          <a 
            href="/update"
            onClick={function(e) {
              e.preventDefault();
              if(this.props.control_id !== 0){
                this.props.onChangeMode('update');
              }
            }.bind(this)}
          >
            update
          </a>
        </li>

        <li>
          <input 
            type="button"
            value="delete"
            onClick={function(e) {
              e.preventDefault();
              this.props.onChangeMode('delete');
              this.props.onChangePage();
            }.bind(this)}
          />
        </li>
      </ul>
    );
  }
}
 
export default Control;