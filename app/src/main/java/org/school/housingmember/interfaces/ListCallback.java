package org.school.housingmember.interfaces;

import java.util.List;

public interface ListCallback<Model> {

    void onSuccess(List<Model> list);

    void onFailure(String message);

}
