import React from 'react';
import * as S from './styles';
import Title from '../../atoms/Title';
import MyLectureCard from '../MyLectureCard';

const MyLectureGroup = ({ data }) => {
  const { title, lectures } = data;

  return (
    <S.Container>
      <S.TitleStyle>
        <Title styleType="SubTitle">{title}</Title>
      </S.TitleStyle>
      <S.GroupStyle>
        {lectures.map(lecture => (
          <MyLectureCard id={lecture.id} data={lecture} />
        ))}
      </S.GroupStyle>
    </S.Container>
  );
};

export default MyLectureGroup;

 

