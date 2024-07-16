package sunderdeep;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener {

    PreparedStatement s;

    JTextField aadharTextField, panTextField;
    JLabel religion, category, occupation, salary, address, existing, senior, pan, education;

    JComboBox religionTextField, categoryTextField, educationTextField,
            occupationTextField, salaryTextField, seniorTextField, existingTextField;

    JButton next, back;
    Long formno;

    public SignupTwo(Long formno) {

        this.formno = formno;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel heading1 = new JLabel("Additional Form :" + formno);
        heading1.setBounds(200, 10, 400, 40);
        heading1.setFont(new Font("Raleway", Font.BOLD, 30));
        image.add(heading1);

        JLabel formtype = new JLabel("Additional Details ");
        formtype.setBounds(100, 80, 300, 30);
        formtype.setFont(new Font("Raleway", Font.BOLD, 24));
        image.add(formtype);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Other"};

        religion = new JLabel("Religion : ");
        religion.setBounds(100, 130, 300, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(religion);

        religionTextField = new JComboBox(valReligion);
        religionTextField.setBounds(300, 130, 300, 30);
        religionTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(religionTextField);

        category = new JLabel("Category : ");
        category.setBounds(100, 180, 300, 30);
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(category);

        String valCategory[] = {"General", "OBC", "SC/ST", "Others"};

        categoryTextField = new JComboBox(valCategory);
        categoryTextField.setBounds(300, 180, 300, 30);
        categoryTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(categoryTextField);

        occupation = new JLabel("Occupation : ");
        occupation.setBounds(100, 230, 300, 30);
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(occupation);

        String valOccupation[]={"Self-Employed","Salaried","Businessman","Student"};
        occupationTextField = new JComboBox(valOccupation);
        occupationTextField.setBounds(300, 230, 300, 30);
        occupationTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(occupationTextField);
        
        String valSalary[]={"Less than 1 Lakh","Less than 2 Lakh","Less than 5 Lakh","More than 5 Lakh"};

        salary = new JLabel("Salary : ");
        salary.setBounds(100, 280, 300, 30);
        salary.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(salary);

        salaryTextField = new JComboBox(valSalary);
        salaryTextField.setBounds(300, 280, 300, 30);
        salaryTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(salaryTextField);
        
        

        education = new JLabel("Education  : ");
        education.setBounds(100, 330, 300, 30);
        education.setBackground(Color.WHITE);
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(education);

        String valEducation[] ={"Graduation","Intermediate","Matriculation"};
        educationTextField = new JComboBox(valEducation);
        educationTextField.setBounds(300, 330, 300, 30);
        educationTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(educationTextField);

        pan = new JLabel("PAN Number : ");
        pan.setBounds(100, 380, 300, 30);
        pan.setBackground(Color.WHITE);
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(pan);

        panTextField = new JTextField();
        panTextField.setBounds(300, 380, 300, 30);
        panTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(panTextField);

        address = new JLabel("Aadhar Number : ");
        address.setBounds(100, 430, 300, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(address);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(300, 430, 300, 30);
        aadharTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(aadharTextField);

        senior = new JLabel("Senior Citizen : ");
        senior.setBounds(100, 480, 300, 30);
        senior.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(senior);

        String valSeniorCitizen[]={"Yes","No"};
        seniorTextField = new JComboBox(valSeniorCitizen);
        seniorTextField.setBounds(300, 480, 300, 30);
        seniorTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(seniorTextField);

        existing = new JLabel("Existing Account : ");
        existing.setBounds(100, 530, 300, 30);
        existing.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(existing);

        String valExistingAccount[]={"Yes","No"};
        existingTextField = new JComboBox(valExistingAccount);
        existingTextField.setBounds(300, 530, 300, 30);
        existingTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(existingTextField);

        JCheckBox check = new JCheckBox("All the details should be filled according to AadharCard");
        check.setBounds(100, 600, 600, 30);
        check.setFont(new Font("Raleway", Font.BOLD, 18));
        check.setBackground(Color.WHITE);
        image.add(check);

        next = new JButton("Next");
        next.setBounds(500, 700, 100, 30);
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        image.add(next);

        back = new JButton("back");
        back.setBounds(300, 700, 100, 30);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setSize(750, 800);
        setLocation(300, 10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SignupTwo(5L);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sreligion=""+religionTextField.getSelectedItem();
        String soccupation=""+occupationTextField.getSelectedItem();
        String scategory=""+categoryTextField.getSelectedItem();
        String ssalary=""+salaryTextField.getSelectedItem();
        String ssenior=""+seniorTextField.getSelectedItem();
        String sexisting=""+existingTextField.getSelectedItem();
        String seducation=""+educationTextField.getSelectedItem();
        String saadharcard=aadharTextField.getText();
        String spancard=panTextField.getText();
                
                
            if(scategory.isEmpty() || sreligion.isEmpty() || soccupation.isEmpty() || 
                    ssalary.isEmpty() || seducation.isEmpty()||spancard.isEmpty()
                    ||saadharcard==null||ssenior.isEmpty()||sexisting.isEmpty()  ){
            
                
                JOptionPane.showMessageDialog(null,"All Fields should be filled ");

            }
            else
            {
               
            try {

                Conn conn = new Conn();
                String query = "insert into signuptwo value(?,?,?,?,?,?,?,?,?,?)";
                s = conn.c.prepareStatement(query);
                s.setString(2, sreligion);
                s.setLong(1, formno);
                s.setString(3,scategory);
                s.setString(4, soccupation);
                s.setString(5, ssalary);  
                s.setString(8, saadharcard);
                s.setString(9, ssenior);
                s.setString(10, sexisting);
                s.setString(6, seducation);
                 s.setString(7, spancard);
              
                s.executeUpdate();

                setVisible(false);
            //    new SignupThree(formno).setVisible(true);

            } catch (SQLException ex) {
                System.out.println(ex);
            }
            

        }
        if(e.getSource() == back)
        {
            setVisible(false);
            
            new SignupOne().setVisible(true);
            
        }
    }

}

