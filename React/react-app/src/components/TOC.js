import React, { Component } from 'react';

class TOC extends Component {
  shouldComponentUpdate(newProps, newState) { // return true면 render 호출, return false면 render 비호출
    if(this.props.data === newProps.data) {
      return false;
    }
    return true;
  }
  render() { 
    let lists = [];
    let data = this.props.data;

    for(let i = 0; i < data.length; i++) {
      lists.push(
        <li key={data[i].id}>
          <a 
            href={"/content/"+data[i].id}
            onClick={
              function(id, e) {
                e.preventDefault();
                this.props.onChangePage(id);
              }.bind(this, data[i].id)
            }
          >
            {data[i].title}
          </a>
        </li>
      );
    }
    return (
      <nav>
        <ul>
          {lists}
        </ul>
      </nav>
    );
  }
}

export default TOC;