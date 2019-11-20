package com.parting_soul.compiler;

import com.google.auto.service.AutoService;
import com.parting_soul.annoation.ARouter;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * @author parting_soul
 * @date 2019-11-19
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes(value = "com.parting_soul.annoation.ARouter")
@SupportedOptions("content")
public class CoreProcessor extends AbstractProcessor {

    /**
     * 用于获取  包，类元素节点信息
     */
    private Elements mElementUtils;

    private Types mTypeUtils;

    /**
     * 用来输出日志
     */
    private Messager mMessager;

    /**
     * 文件生成器
     */
    private Filer mFiler;

    /**
     * 初始化方法
     *
     * @param processingEnvironment
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mElementUtils = processingEnvironment.getElementUtils();
        mMessager = processingEnvironment.getMessager();
        mFiler = processingEnvironment.getFiler();
        mTypeUtils = processingEnvironment.getTypeUtils();

        Map<String, String> options = processingEnvironment.getOptions();
        mMessager.printMessage(Diagnostic.Kind.NOTE, "======>>>" + options.get("content"));
    }

    /**
     * 指定处理的注解
     *
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }


    /**
     * 注解处理器支持的参数
     *
     * @return
     */
    @Override
    public Set<String> getSupportedOptions() {
        return super.getSupportedOptions();
    }


    /**
     * 指定java支持的版本
     *
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }

    /**
     * 注解处理
     *
     * @param set
     * @param roundEnvironment
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (set == null || set.isEmpty()) {
            return false;
        }
        mMessager.printMessage(Diagnostic.Kind.NOTE, "==>>process " + set.toString());

        //获取所有使用ARouter注解的节点
        Set<? extends Element> sets = roundEnvironment.getElementsAnnotatedWith(ARouter.class);
        if (sets == null || sets.isEmpty()) {
            return false;
        }

        for (Element e : sets) {
            mMessager.printMessage(Diagnostic.Kind.NOTE, "==>>annotation " + e.getSimpleName());
            PackageElement packageElement = mElementUtils.getPackageOf(e);
            String packageName = packageElement.getQualifiedName().toString();
            mMessager.printMessage(Diagnostic.Kind.NOTE, packageName);

            String className = e.getSimpleName() + "$ARouter";

            Writer writer = null;
            try {
                JavaFileObject fileObject = mFiler.createSourceFile(className);
                writer = fileObject.openWriter();
                writer.write("package " + packageName + ";\n");
                writer.write("public class " + className + " {\n");
                writer.write("public Class<?> geTargetClass() {\n");
                writer.write(" return " + e.getSimpleName() + ".class;\n");
                writer.write("}\n");
                writer.write("}\n");
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        return true;
    }

}
