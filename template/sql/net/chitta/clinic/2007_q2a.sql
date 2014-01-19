SELECT 
  patient."patName", 
  patient."patAddr", 
  patient."DOB", 
  contains."admissionDate", 
  drug."drugName", 
  prescribed."startDate", 
  prescribed."finishDate"
FROM 
  public.patient, 
  public.contains, 
  public.prescribed, 
  public.drug
WHERE 
  patient."patientNo" = contains."patientNo" AND
  patient."patientNo" = prescribed."patientNo" AND
  prescribed."drugNo" = drug."drugNo";