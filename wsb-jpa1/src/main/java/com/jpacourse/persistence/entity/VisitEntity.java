package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime visitDate;

	@Column(nullable = false)
	private String doctorName;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private PatientEntity patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;


	@ManyToMany
	@JoinTable(
			name = "visit_treatment",
			joinColumns = @JoinColumn(name = "visit_id"),
			inverseJoinColumns = @JoinColumn(name = "treatment_id")
	)
	private List<MedicalTreatmentEntity> treatments;

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public LocalDateTime getVisitDate() { return visitDate; }
	public void setVisitDate(LocalDateTime visitDate) { this.visitDate = visitDate; }

	public String getDoctorName() { return doctorName; }
	public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

	public PatientEntity getPatient() { return patient; }
	public void setPatient(PatientEntity patient) { this.patient = patient; }

	public List<MedicalTreatmentEntity> getTreatments() { return treatments; }
	public void setTreatments(List<MedicalTreatmentEntity> treatments) { this.treatments = treatments; }
}
