import styled from 'styled-components';

const Section = styled.div`
  border: 3 solid black;
  display: flex;
  align-items: justify;
  height: 100vh;
  width: auto;
`;

const FirstDIV = styled.div`
  background-color: yellow;
  width: 200px;
  height: 400px;
`;

const SecondDIV = styled.div`
  background-color: red;
  width: 200px;
  height: 400px;
`;

const ThirdDIV = styled.div`
  background-color: green;
  width: 200px;
  height: 400px;
`;

const SecondSection = () => {
  return (
    <Section>
      <FirstDIV />
      <SecondDIV />
      <ThirdDIV />
    </Section>
  );
};

export default SecondSection;
