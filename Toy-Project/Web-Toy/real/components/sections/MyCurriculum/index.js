import React from 'react';
import * as S from './styles';
import MySectionHeader from '../../modules/MySectionHeader';
import MyLectureGroup from '../../molecules/MyLectureGroup';

const MyCurriculum = ({ datalist }) => {
  return (
    <S.Container>
      <S.HeaderStyle>
        <MySectionHeader title="커리 큘럼" description="정보보안전문가가 되기 위해 4년간 이런 것들을 배우고 경험해요" />
      </S.HeaderStyle>
      <S.GroupStyle>
        {datalist.curriculumDatas.map(data => (
          <MyLectureGroup data={data} />
        ))}
      </S.GroupStyle>
    </S.Container>
  )
};

export default MyCurriculum;