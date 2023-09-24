package com.example.Job.Search.Portal.Service;

import com.example.Job.Search.Portal.Model.Job;
import com.example.Job.Search.Portal.Model.JobType;
import com.example.Job.Search.Portal.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    public String createJob(Job job) {
        Job savedJob = jobRepository.save(job);
        return "Job created with ID: " + savedJob.getId();
    }

    public String getJobById(Long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        return jobOptional.map(job -> "Job found: " + job.toString()).orElse("Job not found");
    }

    public String updateJob(Long id, Job job) {
        Optional<Job> existingJobOptional = jobRepository.findById(id);
        if (existingJobOptional.isPresent()) {
            Job existingJob = existingJobOptional.get();
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setLocation(job.getLocation());
            existingJob.setSalary(job.getSalary());
            existingJob.setCompanyEmail(job.getCompanyEmail());
            existingJob.setCompanyName(job.getCompanyName());
            existingJob.setEmployerName(job.getEmployerName());
            existingJob.setJobType(job.getJobType());
            existingJob.setAppliedDate(job.getAppliedDate());
            jobRepository.save(existingJob);
            return "Job updated with ID: " + existingJob.getId();
        } else {
            return "Job not found";
        }
    }

    public String deleteJob(Long id) {
        jobRepository.deleteById(id);
        return "Job with ID " + id + " deleted";
    }
    public String searchJobsByTitleAndDescription(String title, String description) {
        List<Job> jobs = jobRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(title, description);
        return "Search result: " + jobs.toString();
    }

    public String searchJobsByTitle(String title) {
        List<Job> jobs = jobRepository.findByTitleContainingIgnoreCase(title);
        return "Search result: " + jobs.toString();
    }

    public String searchJobsByDescription(String description) {
        List<Job> jobs = jobRepository.findByDescriptionContainingIgnoreCase(description);
        return "Search result: " + jobs.toString();
    }



    public String searchJobsWithSalaryAbove(double salary) {
        List<Job> jobs = jobRepository.findJobsWithSalaryAbove(salary);
        return "Search result: " + jobs.toString();}




    public String searchJobsByCompanyName(String companyName) {
        List<Job> jobs = jobRepository.findJobsByCompanyName(companyName);
        return "Search result: " + jobs.toString();
    }
    public String searchJobsByEmployerName(String employerName) {
        List<Job> jobs = jobRepository.findJobsByEmployerName(employerName);
        return "Search result: " + jobs.toString();
    }

    public String searchJobsByType(JobType jobType) {
        List<Job> jobs = jobRepository.findByJobType(jobType);
        return "Search result: " + jobs.toString();
    }


    public String searchJobsByLocation(String location) {
        List<Job> jobs = jobRepository.findJobsByLocation(location);
        return "Search result: " + jobs.toString();
    }
        }