import React, { Component } from 'react';
import TOC from './components/TOC';
import ReadContent from './components/ReadContent';
import Subject from './components/Subject';
import Control from './components/Control';
import CreateContent from './components/CreateContent';
import UpdateContent from './components/UpdateContent';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.max_content_id = 3;
    this.state = {
      mode:'welcome',
      selected_content_id:0,

      subject:{title:'WEB', sub:'World Wide Web!'},

      welcome:{title:'Welcome', desc:'Hello, React!'}, 
      
      contents:[
        {id:1, title:'HTML', desc:'HTML is for Information'},
        {id:2, title:'CSS', desc:'CSS is for Design'},
        {id:3, title:'JavaScript', desc:'JavaScript is for Interactive'}
      ]
    }
  }

  getReadContent() {
    for(let i = 0; i < this.state.contents.length; i++) {
      let data = this.state.contents[i];
      
      if(data.id === this.state.selected_content_id) {
        return data;
      }
    }
  }

  getContent() {
    let _article = null;

    if(this.state.mode === 'welcome') {
      let _title = this.state.welcome.title;
      let _desc = this.state.welcome.desc;
      _article = <ReadContent title={_title} desc={_desc}/>;
    } 
    else if(this.state.mode === 'read') {
      let _content = this.getReadContent();
      _article = <ReadContent title={_content.title} desc={_content.desc}/>;
    }
    else if(this.state.mode === 'create') {
      _article = <CreateContent
        onSubmit={function(_title, _desc) {
          this.max_content_id++;
          let _contents = this.state.contents.concat(
            {id:this.max_content_id, title:_title, desc:_desc}
          );
          this.setState({
            contents:_contents
          });
        }.bind(this)}
      />
    }
    else if(this.state.mode === 'update') {
      let _content = this.getReadContent();
      _article = <UpdateContent data={_content} onSubmit={
        function(_id, _title, _desc) {
          let _contents = Array.from(this.state.contents);
          for(let i = 0; i < _contents.length; i++) {
            if(_contents[i].id === _id) {
              _contents[i] = {id:_id, title:_title, desc:_desc};
              break;
            }
          }
          this.setState({
            contents:_contents
          });
        }.bind(this)}
      />
    }

    return _article;
  }

  render() {
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
        /> {/* Subject */}

        <Control
          control_id={this.state.selected_content_id}
          onChangePage={function() {
            this.setState({
              selected_content_id:0
            })
          }.bind(this)}
          onChangeMode={function(_mode) {
            if(_mode === 'delete') {
              if(window.confirm('really?')) {
                let _contents = Array.from(this.state.contents);

                for(let i = 0; i < _contents.length; i++) {
                  if(_contents[i].id === this.state.selected_content_id) {
                    _contents.splice(i, 1);
                    break;
                  }
                }

                this.setState({
                  mode:'welcome',
                  contents:_contents
                });
                
                alert('deleted!');
              }
            }
            else {
              this.setState({
                mode:_mode
              })
            }
          }.bind(this)}
        /> {/* Control */}
        
        <TOC 
          data={this.state.contents}
          onChangePage={function(id) {
            this.setState({
              mode:'read',
              selected_content_id:Number(id)
            });
          }.bind(this)}
        /> {/* TOC */}
        
        {this.getContent()}
      </div>
    );
  }
}

export default App;