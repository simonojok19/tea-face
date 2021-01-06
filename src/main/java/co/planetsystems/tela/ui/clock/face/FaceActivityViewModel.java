package co.planetsystems.tela.ui.clock.face;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.planetsystems.tela.Repository;
import co.planetsystems.tela.data.teacher.Teacher;

public class FaceActivityViewModel extends AndroidViewModel {
    Repository repository;

    public FaceActivityViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.Companion.getInstance(application);
    }

    public LiveData<List<Teacher>> getTeachersList() {
        return null;
    }

    public Teacher getTeacherByNationalId(String nationalId) {
        Teacher teacher = null;
        try {
                teacher = repository.getTeacherByNationalID(nationalId);
        } catch (Exception ignored) {

        }
        return teacher;
    }

    public void updateTeacher(Teacher teacher) {
        repository.updateTeacher(teacher);
    }


    public List<Teacher> getTeachers() {
        List<Teacher> teachers = null;
        try {
            teachers = repository.getTeachers();

        } catch (Exception ignored) {}
        return teachers;
    }
}
