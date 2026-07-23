export const blogs = [
  {
    id: 1,
    title: "React Learning",
    author: "Stephen Biz",
    content: "Welcome to learning React!",
  },
  {
    id: 2,
    title: "Installation",
    author: "Schwzedenier",
    content: "You can install React from npm.",
  },
];

function BlogDetails(props) {
  return (
    <ul>
      {props.blogs.map((blog) => (
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <h4>{blog.author}</h4>
          <p>{blog.content}</p>
        </div>
      ))}
    </ul>
  );
}

export default BlogDetails;