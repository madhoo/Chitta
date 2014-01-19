SELECT 
  patient."patName", 
  patient."patAddr", 
  patient."DOB", 
  ward."wardName", 
  ward."wardType", 
  contains."admissionDate"
FROM 
  public.patient, 
  public.ward, 
  public.contains
WHERE 
  patient."patientNo" = contains."patientNo" AND
  contains."wardNo" = ward."wardNo";
  