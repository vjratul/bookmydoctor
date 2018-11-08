<%@page import="com.models.Patient"%>
<%@page import="java.util.List"%>
<%@page import="com.models.Doctor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css" href="<c:url value="css/style.css" />" />
        <title>Book My Doctor </title>
    </head>

    <body>
        <div id="container">
            <div id="header">
                <h1><span class="off">Book My Doctor</span></h1>

            </div>   

            <div id="menu">
                <ul>
                    
                    <li class="menuitem"><a href="Home">Home</a></li>
                    <li class="menuitem"><a href="findDoctor">Find Doctor</a></li>
                    
                   <li class="menuitem"><a href="showAllPatients">Patient Information</a></li>
                    <li class="menuitem"><a href="contactUs">Contact Us</a></li>

                </ul>
            </div>

            <div id="leftmenu">

                <div id="leftmenu_top"></div>

                <div id="leftmenu_main">    

                    <h3>Dipartments</h3>

                    <ul>
                        <li><a href="getDoctors?type=medicine">Medicine</a></li>
                        <li><a href="getDoctors?type=cardiology">Cardiology</a></li>
                        <li><a href="getDoctors?type=gynecology">Gynecology</a></li>
                        <li><a href="getDoctors?type=neurology">Neurology</a></li>
                        <li><a href="getDoctors?type=pediatric">Pediatric</a></li>
                        <li><a href="getDoctors?type=urology">Urology</a></li>
                        <>
                    </ul>
                </div>
            </div>

            <div id="leftmenu">





            </div>


            <div id="leftmenu_bottom"></div>
        </div>




        <div id="content">


            <div id="content_top"></div>
            <div id="content_main">
                <h2>Here You Can Find Different Types of Specialist Doctors </h2>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <h3>Doctors</h3>
                <p>Find Doctors</p>
                <p>&nbsp;</p>
                <h3></h3>
                <p></p>
                <p>&nbsp;</p>

            </div>
            <div id="content_bottom"></div>


        </div>
        <!--</div>-->

        <%if (request.getAttribute("doctorsByType") != null) {%>
        <table border="2" style="background-color: skyblue">
            <tr>
                <th>
                    Name
                </th>

                <th>
                    EducationalBackground
                </th>

                <th>
                    Email
                </th>

                <th>
                    Designation
                </th>

                <th>
                    Phone Number
                </th>

                <th>
                    Visiting Fee
                </th>

                <th>
                    Book
                </th>

            </tr>
            <% for (Doctor doctor : (List<Doctor>) request.getAttribute("doctorsByType")) {%>

            <tr>


                <td>
                    <%= doctor.getName()%>
                </td>
                <td>
                    <%= doctor.getEducationalBackground()%>
                </td>
                <td>
                    <%= doctor.getEmail()%>
                </td>

                <td>
                    <%= doctor.getDesignation()%>
                </td>
                <td>
                    <%= doctor.getPhoneNumber()%>
                </td>
                <td>
                    <%= doctor.getVisitingFee()%>
                </td>

                <td>
                    <a href="doBooking?id=<%= doctor.getId()%>">BOOK</a>
                </td>

            </tr>
            <%}%>
        </table>
        <%}%>

        <div id="content">
            <% if (request.getAttribute("bookingDone") != null) {%>
            <h2><%= request.getAttribute("bookingDone")%></h2>
            <%}%>

            <%if (request.getAttribute("showForm") != null) {%>

            <form method="POST" action="enterPatientInfo">
                <input type="hidden" name="id" value="<%= request.getAttribute("id")%>">
                    <input type="text" name="patientName" required="true" placeholder="Enter name">
                        <br>
                            <input type="text" name="phoneNumber" required="true" placeholder="Enter number">
                                <input type="submit" value="REGISTER">
                                    </form>

                                    <%}%>

                                    <%if (request.getAttribute("showAllPatients") != null) {%>
                                    <table border="4">
                                        <tr>
                                            <th>
                                                Patient Name
                                            </th>
                                            <th>
                                                Phone Number
                                            </th>
                                            <th>
                                                Doctor Name
                                            </th>
                                            <th>
                                                Serial Number
                                            </th>
                                        </tr> 


                                        <%for (Patient patient : (List<Patient>) request.getAttribute("showAllPatients")) {%>
                                        <tr>
                                            <td>
                                                <%= patient.getPatientName()%>
                                            </td>
                                            <td>
                                                <%= patient.getPhoneNumber()%>
                                            </td>
                                            <td>
                                                <%= patient.getDoctorName()%>
                                            </td>
                                            <td>
                                                <%= patient.getSerialNumber()%>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </table>
                                    <%}%>
                                    </div>

                                    </body>
                                    </html>
