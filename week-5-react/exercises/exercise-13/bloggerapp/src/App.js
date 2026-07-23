import "./App.css";

import BookDetails, { books } from "./Components/BookDetails";
import BlogDetails, { blogs } from "./Components/BlogDetails";
import CourseDetails, { courses } from "./Components/CourseDetails";

function App() {
  const showData = true;

  return (
    <div className="container">

      {showData ? (
        <>
          <div className="column">
            <h1>Course Details</h1>
            <CourseDetails courses={courses} />
          </div>

          <div className="column">
            <h1>Book Details</h1>
            <BookDetails books={books} />
          </div>

          <div className="column">
            <h1>Blog Details</h1>
            <BlogDetails blogs={blogs} />
          </div>
        </>
      ) : (
        <h2>No Data Available</h2>
      )}

    </div>
  );
}

export default App;