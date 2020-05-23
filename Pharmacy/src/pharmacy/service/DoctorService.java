package pharmacy.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pharmacy.dao.DoctorDao;
import pharmacy.entity.Doctor;

public class DoctorService {

    private DoctorDao doctorDao;

    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }
    
    public void add(Doctor obj) {
        if (obj.getId() == null) {
            doctorDao.create(obj);
        } else {
            doctorDao.update(obj);
        }
    }
    
    public Doctor getById(Long id) {
        return doctorDao.read(id);
    }
    
    public List<Doctor> getAll(){
        List<Doctor> reverse = doctorDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        doctorDao.delete(id);
    }
    
    public void decoding(Doctor doctor) throws UnsupportedEncodingException {
        String name = new String(doctor.getDoctorFullName().getBytes("iso-8859-1"), "utf-8");
        doctor.setDoctorFullName(name);
    }
    
    public ArrayList<String> check(Doctor doctor) {
        ArrayList<String> errors = new ArrayList<String>();
        if (doctor.getDoctorFullName().length() > 80) {
            errors.add("Длина ФИО не может быть больше 80 символов");
        }
        return errors;
    }

}
