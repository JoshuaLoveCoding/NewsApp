package edu.gwu.alohanews.common;

import android.os.Bundle;

public interface AlohaFragmentManager {
    //    void doFragmentTransaction(TinBasicFragment basicFragment);

    void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle);

    void showSnackBar(String message);
}
