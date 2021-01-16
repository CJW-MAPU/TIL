import React from 'react';
import * as S from './styles';
import Title from '../../atoms/Title';
import Description from '../../atoms/Description';

const MySectionHeader = ({ title, description }) => {
  return (
    <S.Container>
      <Title styleType="MainTitle">{title}</Title>
      <Description styleType="PrimaryDescription">{description}</Description>
    </S.Container>
  );
};

export default MySectionHeader;