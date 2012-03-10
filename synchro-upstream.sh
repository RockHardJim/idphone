find ./src/com/ -name "*.java" -type f -exec sed -i 's/^import kz\.telecom\.R;$/import com.csipsimple.R;/' {} \;

meld ./ ../CSipSimple

find ./src/com/ -name "*.java" -type f -exec sed -i 's/^import com\.csipsimple\.R;$/import kz.telecom.R;/' {} \;
