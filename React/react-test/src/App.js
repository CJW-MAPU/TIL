import React, { Component } from 'react';
import Subject from './components/Subject';
import TOC from './components/TOC';
import Content from './components/Content';


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      mode:'read',
      selected_content_id:1,

      subject:{title:'WEB', sub:'World Wide Web!'},
      content:{title:'Welcome', desc:'Hello, React!'},

      contents:[
        {id:1, title:'HTML', desc:'HTML is Information'},
        {id:2, title:'CSS', desc:'CSS is Design'},
        {id:3, title:'JavaScript', desc:'JavaScript is Interactive'}
      ]
    }
  }

  render() { 
    var _title, _desc = null;

    if(this.state.mode === 'welcome') {
      _title = this.state.content.title;
      _desc = this.state.content.desc;
    }
    else if(this.state.mode === 'read') {
      var i = 0;

      while(i < this.state.contents.length) {
        var data = this.state.contents[i];

        if(data.id === this.state.selected_content_id) {
          _title = this.state.contents[i].title;
          _desc = this.state.contents[i].desc;
          break;
        }
        i = i + 1;
      }
    }

    return (
      <div className="App">
        <Subject 
          title={this.state.subject.title}
          sub={this.state.subject.sub}
          onChangePage={function() {
            this.setState({
              mode:'welcome',
              selected_content_id:0
            });
          }.bind(this)}
        />

        <TOC  
          data={this.state.contents}
          onChangePage={function(id) {
            this.setState({
              mode:'read',
              selected_content_id:Number(id)
            })
          }.bind(this)}
        />

        <Content title={_title} desc={_desc}/>
      </div>
    );
  }
}
 
export default App;