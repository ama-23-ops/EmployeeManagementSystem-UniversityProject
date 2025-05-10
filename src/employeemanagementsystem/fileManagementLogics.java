/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amasha
 */
public class fileManagementLogics {
    
    //Method to save admins data
    private static final String FILE_NAME = "user_data.txt";
    
    public static void saveAdminDataToFile(String userName, String email, String designation, String password) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
            writer.write("UserName =" + userName + ", email =" + email + ", Role =" + designation 
                    + ", Password =" + password + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Admin data saved successfully.", "Saving Successful", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error while saving admin data: ", "error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
  
   //Methods to save and set table of departments
   private static final String DEP_FILE_NAME = "department_data.txt";

   private static DefaultTableModel tableModel; // Reference to the table model

    // Method to set the table model (called from HRManagerForm)
    public static void setTableModel(DefaultTableModel model) {
        tableModel = model;
        loadDepartmentDataFromFile(); // Load existing data into the table model
    }

    // Method to load existing department data from the file and update the table model
    private static void loadDepartmentDataFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DEP_FILE_NAME));
            String line;
            
            // Clear existing rows before loading new data
            tableModel.setRowCount(0);
            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String departmentID = data[0].substring(data[0].indexOf("=") + 1).trim();
                String departmentName = data[1].substring(data[1].indexOf("=") + 1).trim();
                tableModel.addRow(new Object[]{departmentID, departmentName});
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error while loading department data: ", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

     //Method to save departments data
     public static void saveDepartmentToFile(Department department) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DEP_FILE_NAME, true));
            writer.write("Department ID =" + department.getDepartmentID() + ", Department Name =" + department.getDepartmentName() + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Department data saved successfully.", "Saving Successful", JOptionPane.ERROR_MESSAGE);
            
             // Read the file and update the table model immediately
            loadDepartmentDataFromFile();
        
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error while saving department data: ", "error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
      
    //Methods for designation
    private static final String DES_FILE_NAME = "designation_data.txt";

   private static DefaultTableModel tableModelDes; // Reference to the table model

    // Method to set the table model (called from HRManagerForm)
    public static void setDesignationTableModel(DefaultTableModel model) {
        tableModelDes = model;
        loadDesignationDataFromFile(); // Load existing data into the table model
    }

    // Method to load existing designation data from the file and update the table model
    private static void loadDesignationDataFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DES_FILE_NAME));
            String line;
            
            // Clear existing rows before loading new data
            tableModelDes.setRowCount(0);
        
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String designationID = data[0].substring(data[0].indexOf("=") + 1).trim();
                String designationName = data[1].substring(data[1].indexOf("=") + 1).trim();
                tableModelDes.addRow(new Object[]{designationID, designationName});
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error while loading designation data: ", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

     //Method to save designation data
    public static void saveDesignationToFile(Designation designation) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DES_FILE_NAME, true));
            writer.write("Designation ID =" + designation.getDesignationID() + ", Designation Name =" + designation.getDesignationName() + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Designation data saved successfully.", "Saving Successful", JOptionPane.ERROR_MESSAGE);
            
             // Read the file and update the table model immediately
            loadDesignationDataFromFile();
        
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error while saving Designation data: ", "error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    //Methods for employee data
    private static final String EMP_FILE_NAME = "employee_data.txt";

   private static DefaultTableModel tableModelEmp; // Reference to the table model

    // Method to set the table model (called from HRManagerForm)
    public static void setEmployeeTableModel(DefaultTableModel model) {
        tableModelEmp = model;
        loadEmployeeDataFromFile(); // Load existing data into the table model
    }

    // Method to load existing employee data from the file and update the table model
    private static void loadEmployeeDataFromFile() {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(EMP_FILE_NAME));
        String line;
        
        // Clear existing rows before loading new data
        tableModelEmp.setRowCount(0);

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            String employeeFName = data[0].substring(data[0].indexOf("=") + 1).trim();
            String employeeLName = data[1].substring(data[1].indexOf("=") + 1).trim();
            String employeeEpf = data[2].substring(data[2].indexOf("=") + 1).trim();
            String employeeDep = data[3].substring(data[3].indexOf("=") + 1).trim();
            String employeeDes = data[4].substring(data[4].indexOf("=") + 1).trim();
            tableModelEmp.addRow(new Object[]{employeeFName, employeeLName, employeeEpf, employeeDep, employeeDes});
        }
        reader.close();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error while loading employee data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

     //Method to save employee data
    public static void saveEmployeeToFile(Employee employee) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(EMP_FILE_NAME, true));
            writer.write("Employee First Name =" + employee.getFirstName() + ", Employee Last Name =" + employee.getLastName() + ", Employee EPF =" + employee.getEpf() + ", Employee Dep =" + employee.getDepartment() + ", Employee Des =" + employee.getDesignation() + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Employee data saved successfully.", "Saving Successful", JOptionPane.ERROR_MESSAGE);
         
            // Read the file and update the table model immediately
            loadEmployeeDataFromFile();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error while saving employee data: ", "error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
   

    
   
   
     

     
     