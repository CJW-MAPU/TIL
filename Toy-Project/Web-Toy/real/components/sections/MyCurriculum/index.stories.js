import MyCurriculum from '.';
import { data } from './data';

export default {
  title: "sections / MyCurriculum",
  component: MyCurriculum,
};

const Template = (args) => <MyCurriculum {...args} />;

export const Rendering = Template.bind({});
Rendering.args = {
  datalist: data,
}