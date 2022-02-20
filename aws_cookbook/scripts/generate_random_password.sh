aws secretsmanager get-random-password \
     --exclude-punctuation \
     --password-length 41 --require-each-included-type \
     --output text \
     --query RandomPassword