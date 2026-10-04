package org.redsxi.iul;

import org.redsxi.iul.launch.LaunchThread;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Launcher {
    public static IulConfig launch(IulConfig config, String name, String threadName, ClassLoader parentClassLoader) {
        IulConfig c = config.child();
        long id = System.currentTimeMillis();
        LaunchThread thread = new LaunchThread(id, name, threadName);
        c.addClass(thread);
        IulClassLoader loader = new IulClassLoader(c, parentClassLoader);
        try {
            Class<?> threadClass = loader.loadClass(thread.getName());
            Constructor<?> threadConstructor = threadClass.getConstructor();
            Thread t = (Thread) threadConstructor.newInstance();
            t.start();
        } catch (
                ClassNotFoundException |
                NoSuchMethodException |
                InvocationTargetException |
                InstantiationException |
                 IllegalAccessException
                        e) {
            throw new RuntimeException(e);
        }
        return c;
    }
}
