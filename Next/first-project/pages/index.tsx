import styled from 'styled-components';
import Link from 'next/link';

const Title = styled.h1`
  color: #2f5fd1;
`;

const Home = () => {
  return (
    <div>
      <Title>Hello World!</Title>
      <Link href={`/posts/[id]`} as={`/posts/1`}>
        <a>
          포스트 상세 페이지
        </a>
      </Link>
    </div>
  );
};

export default Home;
