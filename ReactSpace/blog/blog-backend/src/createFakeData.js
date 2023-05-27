import Post from './models/post';

export default function createFakeData() {
	// 0, 1, ... 39로 이루어진 배열을 생성한 후 포스트 데이터로 변환
	const posts = [...Array(40).keys()].map((i) => ({
		title: `포스트 #${i}`,
		body: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled',
		tags: ['가짜', '데이터'],
	}));
	Post.insertMany(posts, (err, docs) => {
		console.log(docs);
	});
}
