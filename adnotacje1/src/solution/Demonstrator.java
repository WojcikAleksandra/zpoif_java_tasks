package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.lang.reflect.*;
import java.text.Annotation;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Package;

import pl.edu.pw.mini.zpoif.task5.machine.MafiaMachine;
import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.special.ButtonMan;

public class Demonstrator extends MafiaMachine {
	public static void main(String[] args) {
		
	}

	@Override
	protected Set<MafiaWorker> createImportantMafiaWorkers() throws Exception {
		List<MafiaWorker> importantWorkers = new ArrayList<>();
		String packageName = MafiaWorker.class.getPackageName();
	    InputStream stream = ClassLoader.getSystemClassLoader()
	          .getResourceAsStream(packageName.replaceAll("[.]", "/"));
	    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
	    Set<Class<?>> classes = reader.lines()
	          .filter(line -> line.endsWith(".class"))
	          .map(line -> getClass(line, packageName))
	          .collect(Collectors.toSet());
            for (Class<?> klasa : classes) {
                if (klasa.isAnnotationPresent(ImportantWorker.class)) {
                	int q = klasa.getAnnotation(ImportantWorker.class).quantity();
                    for (int i = 0; i < q; i++) {
                        try {
                            Constructor<?> constructor = klasa.getConstructor();
                            Object instance = constructor.newInstance();
                            importantWorkers.add(instance);
                        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            return new HashSet<>(importantWorkers);
    	}
	

	@Override
	protected MafiaWorker createPrimaryMafiaWorker() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MafiaWorker createPrioritizedPrimaryMafiaWorker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillFields(Set<MafiaWorker> workers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ButtonMan getKiller(String name, String surname) {
		Constructor<ButtonMan> constructor = ButtonMan.class.getDeclaredConstructor(String.class, String.class);
        Annotation[][] parameters = constructor.getParameters();
        for (Parameter parameter : parameters) {
                if (parameter.isAnnotationPresent(LengthValidator.class)) {
                    int maxLength = parameter.getAnnotation(LengthValidator.class).maxLength();
                    String paramValue = parameter.get();
                    if (paramValue.length() > maxLength) {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }

	@Override
	protected void init(MafiaWorker mafiaWorker) {
		Field[] fields = mafiaWorker.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InitMe.class)) {
                field.setAccessible(true);
                Class<?> fieldType = field.getType();

                if (fieldType.isLocalClass()) {
                    Object localInstance = fieldType.newInstance();
                    field.set(mafiaWorker, localInstance);
                }
            }
        }
		
	}

	@Override
	protected void goButtonMan(Set<MafiaWorker> buttonMan) throws Exception {
		        for (MafiaWorker worker : buttonMan) {
		            Class<?> clazz = worker.getClass();
		            Method[] methods = clazz.getDeclaredMethods();
		            for (Method method : methods) {
		                if (method.isAnnotationPresent(DoIt.class)) {
		                    int repeatTimes = method.getAnnotation(DoIt.class).times();
		                    for (int i = 0; i < repeatTimes; i++) {
		                        try {
		                            method.invoke(worker);
		                        } catch (Exception e) {
		                            e.printStackTrace();
		                        }
		                    }
		                }
		            }
		        }
		    }

	@Override
	protected void retreat(ButtonMan buttonMan) {
		// TODO Auto-generated method stub
		
	}
	
	
}
