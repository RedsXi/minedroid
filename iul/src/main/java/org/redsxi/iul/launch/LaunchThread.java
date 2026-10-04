package org.redsxi.iul.launch;

import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.redsxi.iul.IulClass;

import static org.objectweb.asm.Opcodes.*;

public class LaunchThread extends IulClass {
    private final long id;
    private final String clazz;
    private final String threadName;

    public LaunchThread(long id, String clazz) {
        this(id, clazz, "(Iul)Thread " + id);
    }

    public LaunchThread(long id, String clazz, String threadName) {
        super("iul/Thread" + id);
        this.id = id;
        this.clazz = clazz;
        this.threadName = threadName;
    }

    @NotNull
    @Override
    public String superClass() {
        return "java/lang/Thread";
    }

    @Override
    public void generateClassInside(@NotNull ClassWriter writer) {
        MethodVisitor init = writer.visitMethod(
                ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null
        );
        init.visitCode();
        init.visitVarInsn(ALOAD, 0);
        init.visitMethodInsn(INVOKESPECIAL, "java/lang/Thread", "<init>", "()V", false);
        init.visitVarInsn(ALOAD, 0);
        init.visitLdcInsn(threadName);
        init.visitMethodInsn(INVOKEVIRTUAL, getName(), "setName", "(Ljava/lang/String;)V", false);
        init.visitInsn(RETURN);
        init.visitMaxs(2, 1);
        init.visitEnd();

        MethodVisitor entry = writer.visitMethod(
                ACC_PUBLIC | ACC_FINAL,
                "run",
                "()V",
                null,
                null
        );
        entry.visitCode();
        entry.visitMethodInsn(INVOKESTATIC, clazz, "iulEntry", "()V", false);
        entry.visitInsn(RETURN);
        entry.visitMaxs(0, 1);
        entry.visitEnd();
    }
}
