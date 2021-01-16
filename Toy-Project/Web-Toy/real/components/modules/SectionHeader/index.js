import React from "react";
import * as S from "./styles";
import Title from "../../atoms/Title";
import Description from "../../atoms/Description";

const SectionHeader = ({ data }) => {

  return (
    <S.Container>
      <Title styleType="MainTitle">{data}</Title>
      <Description styleType="SecondaryDescription">{data}</Description>
    </S.Container>
  )
}

export default SectionHeader
