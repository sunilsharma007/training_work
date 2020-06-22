package com.example.model;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "task_name")
    @NotNull(message="Must not be Null ")
    @Size(min=1, message="Must not be Null")
    private String taskName;

    @Column(name = "task_Start_date")
    @NotNull(message="Must not be Null ")
    private String taskSDate;

    @Column(name = "task_End_date")
    @NotNull(message="Must not be Null ")
    private String taskEDate;


    @Column(name = "priority")
    @NotNull(message="Must not be Null ")
    private int priority;


}
