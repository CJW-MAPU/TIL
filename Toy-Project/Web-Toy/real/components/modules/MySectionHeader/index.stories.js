import React from "react";
import MySectionHeader from ".";

export default {
  title: "Modules / MySectionHeader",
  component: MySectionHeader
};

const data = {
  title: "커리 큘럼",
  description: "정보보안전문가가 되기 위해 4년간 이런 것들을 배우고 경험해요"
};

const Template = (args) => <MySectionHeader {...args} />;

export const Rendering = Template.bind({});
Rendering.args = {
  title: data.title,
  description: data.description,
};

