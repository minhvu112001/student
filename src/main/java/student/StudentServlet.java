package student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class StudentServlet extends HttpServlet {
    private List<Student> studentList;

    public void init() throws ServletException {
        super.init();
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Nguyen Van Dong", 9.5));
        studentList.add(new Student(2, "Tran The Trung", 8.75));
        studentList.add(new Student(3, "Hoang Mau Phong", 8.4));
        studentList.add(new Student(4, "Hoang Thi My Dieu", 10.9));
        studentList.add(new Student(5, "Trinh Mau Kim", 7.6));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                listStudents(request, response);
                break;
        }
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        double score = Double.parseDouble(request.getParameter("score"));
        int id = studentList.size() + 1;
        Student newStudent = new Student(id, studentName, score);
        studentList.add(newStudent);
        response.sendRedirect("students");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = getStudentById(id);

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String studentName = request.getParameter("studentName");
        double score = Double.parseDouble(request.getParameter("score"));

        Student studentToUpdate = getStudentById(id);
        studentToUpdate.setStudentName(studentName);
        studentToUpdate.setScore(score);
        response.sendRedirect("products");
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Student studentToDelete = getStudentById(id);
        if(studentToDelete != null) {

            studentList.remove(studentToDelete);
        }
        response.sendRedirect("products");
    }
    private Student getStudentById(int id){
        for(Student student : studentList){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

}
