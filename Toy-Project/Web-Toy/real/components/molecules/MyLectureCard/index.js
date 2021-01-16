import React from 'react';
import * as S from './styles';
import Image from '../../atoms/Image';
import Label from '../../atoms/Label';
import Description from '../../atoms/Description';

const MyLectureCard = ({ data }) => {
  const { src, title, description } = data;
  return (
    <S.Container>
      <S.IconStyle>
        <Image styleType="Icon" src={src} />
      </S.IconStyle>
      <S.TextStyle>
        <Label styleType="FirstLabel">{title}</Label>
        <Description styleType="SecondaryDescription">{description}</Description>
      </S.TextStyle>
    </S.Container>
  );
};

export default MyLectureCard;