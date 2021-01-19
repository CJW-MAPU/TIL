import React from "react";
import * as S from "./styles";
import Title from "../../atoms/Title";
import Description from "../../atoms/Description";

const SectionHeader = ({ title, description }) => {

  return (
    <S.Container>
      <Title styleType="MainTitle">{title}</Title>
      <Description styleType="SecondaryDescription">{description}</Description>
    </S.Container>
  )
}

export default SectionHeader
