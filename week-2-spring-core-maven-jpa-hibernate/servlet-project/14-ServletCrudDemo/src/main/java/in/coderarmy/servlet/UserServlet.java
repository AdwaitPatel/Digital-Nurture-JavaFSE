package in.coderarmy.servlet;


import in.coderarmy.model.User;
import in.coderarmy.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        if (idParam == null) {
            // send all users
            List<User> users = service.getAllUsers();

            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(usersToJson(users));
            return;
        }

        Integer id = Integer.parseInt(idParam);
        User userRes = service.getUserById(id);

        if (userRes == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write(
                    """
                            {
                                "message": "User not found"
                            }
                       """
            );
            return;
        }

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson(userRes));

    }

    @Override
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        User existingUser = service.getUserById(id);

        if (existingUser != null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write(
                    """
                            {
                                "message": "User with this id already exists"
                            }
                       """
            );
            return;
        }

        if (id == null || name == null || email == null || mobile == null) {

            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write(
                    """
                            {
                                "message": "Some fields are missing"
                            }
                       """
            );
            return;
        }

        User user = new User(id, name, email, mobile);

        User createdUser = service.createUser(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User Added Successfully\",\n" +
                        "    \"user\" : "+ userToJson(createdUser) + "\n" +
                        "}"
        );

    }

    @Override
    public void doPut(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        User existingUser = service.getUserById(id);

        // check if user exist with this id
        if (existingUser == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write(
                    """
                            {
                                "message": "User not found"
                            }
                       """
            );
            return;
        }

        User updatedUser = service.updateUser(existingUser, name, email, mobile);

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User Updated Successfully\",\n" +
                        "    \"user\" : "+ userToJson(updatedUser) + "\n" +
                        "}"
        );

    }


    @Override
    public void doDelete(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        User existingUser = service.getUserById(id);

        // check if user exist with this id
        if (existingUser == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write(
                    """
                            {
                                "message": "User not found"
                            }
                       """
            );
            return;
        }

        service.deleteUser(id);

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(
                         """
                                {
                                    "message" : "User Deleted Successfully"
                                }
                            """
        );
    }


    public String userToJson(User user) {
        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\" : \"" + user.getName() + "\",\n" +
                "    \"email\" : \"" + user.getEmail() + "\",\n" +
                "    \"mobile\" : \"" + user.getMobile() + "\"\n" +
                "}";
    }

    public String usersToJson(List<User> users) {

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < users.size(); i++) {
            sb.append(userToJson(users.get(i)));
            if (i < users.size() - 1) sb.append(",");
        }

        sb.append("]");


        return sb.toString();
    }
}

















