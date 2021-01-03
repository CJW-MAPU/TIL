import { useRouter } from 'next/router';
import Link from 'next/link';

const PostDetailPage = () => {
  const router = useRouter();

  return (
    <div>
      <Link href="/">
        <a> 홈으로 </a>
      </Link>
      <br />
      Post ID: {router.query.id}
    </div>
  );
};

export default PostDetailPage;

export async function getStaticProps() {}
