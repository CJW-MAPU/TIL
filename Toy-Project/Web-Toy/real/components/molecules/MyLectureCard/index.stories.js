import MyLectureCard from '.';

export default {
  title: "Molecules / MyLectureCard",
  component: MyLectureCard,
};

const data = {
  id: 1,
  title: "C / C++ Language",
  description: "C언어는 프로그래밍 언어의 기초 입니다. 프로그래밍의 기초인 만큼 더욱 상세하게 2학기에 거쳐 학습합니다.",
  src: "/lecture/c_icon.svg",
};

export const Rendering = (args) => <MyLectureCard {...args} />;
Rendering.args = {
  data,
};